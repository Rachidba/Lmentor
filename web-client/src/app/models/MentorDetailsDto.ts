import { Eduction } from './Education.model';
import { Experience } from './Experience.model';

export class MentorDetailsDto {
    constructor(
        public profileId: number,
        public fullName: string,
        public email: string,
        public phoneNumber: string,
        public title: string,
        public descrition: string,
        public sessionPrice: number,
        public educations: Set<Eduction>,
        public experiences: Set<Experience>
    ) {}
}