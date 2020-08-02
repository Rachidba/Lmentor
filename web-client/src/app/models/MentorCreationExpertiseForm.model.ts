import { MentorCreationExpertise } from './MentorCreationExpertise.interface';

export class MentorCreationExpertiseForm {
    data = {
        expertises: new Set<number>()
    } as MentorCreationExpertise;
    isValid = false;
}