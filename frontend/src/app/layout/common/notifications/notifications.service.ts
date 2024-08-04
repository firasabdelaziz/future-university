import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Notification } from 'app/layout/common/notifications/notifications.types';
import { BehaviorSubject, map, Observable, ReplaySubject, switchMap, take, tap } from 'rxjs';
//import * as Stomp from 'stompjs';
//import * as SockJS from 'sockjs-client';

@Injectable({providedIn: 'root'})
export class NotificationsService
{
    private notificationsSubject = new BehaviorSubject<Notification[]>([]);
   // private stompClient: Stomp.Client;
    private baseUrl = 'http://localhost:8888/api'; // Your backend base URL


    /**
     * Constructor
     */
    constructor(private _httpClient: HttpClient)
    {
       // this.initializeWebSocketConnection();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Accessors
    // -----------------------------------------------------------------------------------------------------
/*
    private initializeWebSocketConnection() {
        const socket = new SockJS(`${this.baseUrl}/ws`);
        this.stompClient = Stomp.over(socket);
        this.stompClient.connect({}, (frame) => {
            console.log('Connected: ' + frame);
            
            this.stompClient.subscribe('/topic/public', (message) => {
              if (message.body) {
                const notification: Notification = JSON.parse(message.body);
                this.handleNewNotification(notification);    
              }
            });
          }, (error) => {
            console.error('WebSocket connection error:', error);
          });
      
      }
    

    /**
     * Getter for notifications
     */
    get notifications$(): Observable<Notification[]>
    {
        return this.notificationsSubject.asObservable();
    }

    private handleNewNotification(notification: Notification) {
        const currentNotifications = this.notificationsSubject.value;
        this.notificationsSubject.next([notification, ...currentNotifications]);
      }
    

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Get all notifications
     */
    getAll(): Observable<Notification[]>
    {
        return this._httpClient.get<Notification[]>('api/common/notifications').pipe(
            tap((notifications) =>
            {
                this.notificationsSubject.next(notifications);
            }),
        );
    }

    /**
     * Create a notification
     *
     * @param notification
     */
    create(notification: Notification): Observable<Notification>
    {
        return this.notifications$.pipe(
            take(1),
            switchMap(notifications => this._httpClient.post<Notification>('api/common/notifications', {notification}).pipe(
                map((newNotification) =>
                {
                    // Update the notifications with the new notification
                    this.notificationsSubject.next([...notifications, newNotification]);

                    // Return the new notification from observable
                    return newNotification;
                }),
            )),
        );
    }

    /**
     * Update the notification
     *
     * @param id
     * @param notification
     */
    update(id: string, notification: Notification): Observable<Notification>
    {
        return this.notifications$.pipe(
            take(1),
            switchMap(notifications => this._httpClient.patch<Notification>('api/common/notifications', {
                id,
                notification,
            }).pipe(
                map((updatedNotification: Notification) =>
                {
                    // Find the index of the updated notification
                    const index = notifications.findIndex(item => item.id === id);

                    // Update the notification
                    notifications[index] = updatedNotification;

                    // Update the notifications
                    this.notificationsSubject.next(notifications);

                    // Return the updated notification
                    return updatedNotification;
                }),
            )),
        );
    }

    /**
     * Delete the notification
     *
     * @param id
     */
    delete(id: string): Observable<boolean>
    {
        return this.notifications$.pipe(
            take(1),
            switchMap(notifications => this._httpClient.delete<boolean>('api/common/notifications', {params: {id}}).pipe(
                map((isDeleted: boolean) =>
                {
                    // Find the index of the deleted notification
                    const index = notifications.findIndex(item => item.id === id);

                    // Delete the notification
                    notifications.splice(index, 1);

                    // Update the notifications
                    this.notificationsSubject.next(notifications);

                    // Return the deleted status
                    return isDeleted;
                }),
            )),
        );
    }

    /**
     * Mark all notifications as read
     */
    markAllAsRead(): Observable<boolean>
    {
        return this.notifications$.pipe(
            take(1),
            switchMap(notifications => this._httpClient.get<boolean>('api/common/notifications/mark-all-as-read').pipe(
                map((isUpdated: boolean) =>
                {
                    // Go through all notifications and set them as read
                    notifications.forEach((notification, index) =>
                    {
                        notifications[index].read = true;
                    });

                    // Update the notifications
                    this.notificationsSubject.next(notifications);

                    // Return the updated status
                    return isUpdated;
                }),
            )),
        );
    }
}
