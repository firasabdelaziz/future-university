import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CourseService } from '../course.service';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-course-tasks',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './course-tasks.component.html'
})
export class CourseTasksComponent implements OnInit {
    tasks: any[];
    courseName: string;

    constructor(
        private route: ActivatedRoute,
        private courseService: CourseService,
        private _cdr: ChangeDetectorRef // Inject ChangeDetectorRef
    ) {}

    ngOnInit() {
        console.log("here");
        
        const courseId = this.route.snapshot.paramMap.get('id');
        if (courseId) {
            this.courseService.getCourseTasks(courseId).subscribe(
                (tasks) => {
                    console.log("tasksinside",tasks);
                    this.tasks = tasks;
                    // Assuming you have a method to get course details
                    this.courseService.getCourseById(courseId).subscribe(
                        (course) => {
                            this.courseName = course.name;
                            this._cdr.detectChanges(); // Ensure changes are detected
                        }
                    );
                    this._cdr.detectChanges(); // Ensure changes are detected

                }
            );
        }
    }
}