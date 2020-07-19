import { MentorCreationPersonal } from './MentorCreationPersonal.interface';

export class MentorCreationPersonalForm {
    data = {
        gender: '',
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
        city: ''
    } as MentorCreationPersonal;
    isValid = false;
}