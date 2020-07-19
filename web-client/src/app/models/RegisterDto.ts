import { RoleType } from 'src/app/models/RoleType';

export class RegisterDto {
    constructor(
        public username: string,
        public password: string,
        public role: RoleType
    ) {}
}