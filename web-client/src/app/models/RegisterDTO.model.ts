import { RoleType } from 'src/app/models/RoleType';

export interface RegisterDTO {
    email: string;
    password: string;
    role: RoleType;
}