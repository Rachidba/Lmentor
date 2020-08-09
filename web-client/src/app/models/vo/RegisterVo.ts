import { RoleType } from 'src/app/models/RoleType';

export class RegisterDto {
    constructor(
        public email: string,
        public password: string,
        public role: RoleType
    ) {}
}