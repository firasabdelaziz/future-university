import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';

@Component({
    template: `
        <h2 mat-dialog-title>Delete Course</h2>
        <mat-dialog-content>
            Are you sure you want to delete the course "{{ data.courseName }}"?
        </mat-dialog-content>
        <mat-dialog-actions>
            <button mat-button (click)="onNoClick()">Cancel</button>
            <button mat-button color="warn" (click)="onYesClick()">Delete</button>
        </mat-dialog-actions>
    `,
    standalone: true,
    imports:[
        MatDialogActions,
        MatDialogContent
    ]
})
export class DeleteConfirmationDialogComponent {
    constructor(
        public dialogRef: MatDialogRef<DeleteConfirmationDialogComponent>,
        @Inject(MAT_DIALOG_DATA) public data: { courseName: string }
    ) {}

    onNoClick(): void {
        this.dialogRef.close(false);
    }

    onYesClick(): void {
        this.dialogRef.close(true);
    }
}