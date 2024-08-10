export interface Course {
    id: string;
    name: string;
    description: string;
    userId: {
        id: number;
    };
}

export interface CoursePagination {
    length: number;
    size: number;
    page: number;
    lastPage: number;
    startIndex: number;
    endIndex: number;
}