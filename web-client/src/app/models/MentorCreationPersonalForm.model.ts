import { MentorCreationPersonal } from './MentorCreationPersonal.interface';
import { GenderType } from './GenderType';

export class MentorCreationPersonalForm {
    data = {
        gender: GenderType.GENDER_OTHER,
        firstName: '',
        lastName: '',
        contactEmail: '',
        phoneNumber: '',
        city: ''
    } as MentorCreationPersonal;
    isValid = false;
}