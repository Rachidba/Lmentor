import { RoleType } from './RoleType';

export interface LoginResponse {
    profileId: number;
    fullName: string;
    jwToken: string;
    tokenExpiryDateMillis: number;
    email: string;
    role: RoleType;
}