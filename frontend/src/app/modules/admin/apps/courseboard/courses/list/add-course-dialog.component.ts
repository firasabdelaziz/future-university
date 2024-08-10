import { Component } from '@angular/core';
import { MatDialogActions, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
    template: `
        <h2 mat-dialog-title>Add New Course</h2>
        <mat-dialog-content>
            <form [formGroup]="courseForm">
                <mat-form-field>
                    <input matInput placeholder="Course Name" formControlName="name">
                </mat-form-field>
                <mat-form-field>
                    <textarea matInput placeholder="Description" formControlName="description"></textarea>
                </mat-form-field>
            </form>
        </mat-dialog-content>
        <mat-dialog-actions>
            <button mat-button (click)="onNoClick()">Cancel</button>
            <button mat-button [disabled]="!courseForm.valid" (click)="onSubmit()">Add</button>
        </mat-dialog-actions>
    `,
    standalone:true,
    imports:[
        MatDialogActions,
        MatDialogContent,
        MatFormFieldModule,
        ReactiveFormsModule, // Add ReactiveFormsModule here
        MatInputModule// Ensure MatInputModule is also imported

    ]
})
export class AddCourseDialogComponent {
    courseForm: FormGroup;

    constructor(
        public dialogRef: MatDialogRef<AddCourseDialogComponent>,
        private fb: FormBuilder
    ) {
        this.courseForm = this.fb.group({
            name: ['', Validators.required],
            description: ['', Validators.required],
            userId: this.fb.group({
                id: [1, Validators.required]
            })
        });
    }

    onNoClick(): void {
        this.dialogRef.close();
    }

    onSubmit(): void {
        if (this.courseForm.valid) {
            this.dialogRef.close(this.courseForm.value);
        }
    }
}