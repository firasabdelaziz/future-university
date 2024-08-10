import { inject } from '@angular/core';
import { Routes } from '@angular/router';
import { CourseComponent } from 'app/modules/admin/apps/courseboard/courses/course.component';
import { CourseService } from 'app/modules/admin/apps/courseboard/courses/course.service';
import { CourseListComponent } from 'app/modules/admin/apps/courseboard/courses/list/course.component';

export default [
    {
        path      : '',
        pathMatch : 'full',
        redirectTo: 'courseslist',
    },
    {
        path     : 'courseslist',
        component: CourseComponent,
        children : [
            {
                path     : '',
                component: CourseListComponent,
              
            },
        ],
    },
] as Routes;
