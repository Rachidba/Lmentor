import { GenderType } from './GenderType';

export interface MentorCreationPersonal {
    gender: GenderType;
    firstName: string;
    lastName: string;
    contactEmail: string;
    phoneNumber: string;
    city: string;
}