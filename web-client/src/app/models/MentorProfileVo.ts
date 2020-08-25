import { Experience } from './Experience.model';
import { Eduction } from './Education.model';
import { GenderType } from './GenderType';

export class MentorProfileVo {
    constructor(
        public gender: GenderType,
        public firstName: string,
        public lastName: string,
        public contactEmail: string,
        public phoneNumber: string,
        public title: string,
        public description: string,
        public city: string,
        public expertises: Set<Number>,
        public lastEducation: Eduction,
        public lastExperience: Experience
    ) {}
}