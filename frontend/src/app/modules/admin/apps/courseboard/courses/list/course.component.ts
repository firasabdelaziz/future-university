import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { CourseService } from '../course.service';
import { Course } from '../course.types';
import { MatDialog } from '@angular/material/dialog';
import { AddCourseDialogComponent } from './add-course-dialog.component';
import { DeleteConfirmationDialogComponent } from './delete-dialog-confirmation.component';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { CommonModule } from '@angular/common';

@Component({
    selector     : 'course-list',
    templateUrl  : './course.component.html',
    encapsulation: ViewEncapsulation.None,
    standalone: true,
    imports: [
        CommonModule,
        MatButtonModule,
        MatIconModule,
        MatMenuModule
    ]
    
})
export class CourseListComponent implements OnInit {
    courses: Course[];

    constructor(
        private _courseService: CourseService,
        private _dialog: MatDialog,
        private _cdr: ChangeDetectorRef // Inject ChangeDetectorRef

    ) {}

    ngOnInit(): void {
        this._courseService.getCourses().subscribe((courses) => {
            console.log("here",courses);
            
            this.courses = courses;
            console.log("this.courses",this.courses);

            this._cdr.detectChanges(); // Force change detection

            
        });
    }

    openAddCourseDialog(): void {
        const dialogRef = this._dialog.open(AddCourseDialogComponent, {
            width: '400px'
        });

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this._courseService.createCourse(result).subscribe(() => {
                    // Refresh the course list
                    this._courseService.getCourses().subscribe();
                });
            }
        });
    }

    openDeleteConfirmationDialog(course: Course): void {
        const dialogRef = this._dialog.open(DeleteConfirmationDialogComponent, {
            width: '300px',
            data: { courseName: course.name }
        });

        dialogRef.afterClosed().subscribe(result => {
            if (result) {
                this._courseService.deleteCourse(course.id).subscribe(() => {
                    // Refresh the course list
                    this._courseService.getCourses().subscribe();
                });
            }
        });
    }
}