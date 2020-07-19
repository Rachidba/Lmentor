import { MentorCreationExpertise } from './MentorCreationExpertise.interface';

export class MentorCreationExpertiseForm {
    data = {
        job: '',
        expertiseField: ''
    } as MentorCreationExpertise;
    isValid = false;
}