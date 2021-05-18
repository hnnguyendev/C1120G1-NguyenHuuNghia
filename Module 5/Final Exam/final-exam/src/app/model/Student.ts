import { Teacher } from "./Teacher";

export interface Student {
    id: number;
    name: string;
    team: string;
    topic: string;
    teacher: Teacher;
    email: string;
    phone: string;
}