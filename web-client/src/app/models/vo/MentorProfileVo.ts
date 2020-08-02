import { ExperienceVo } from './ExperienceVo';
import { EducationVo } from './EducationVo';
import { GenderType } from './../GenderType';

export class MentorProfileVo {
    constructor(
        public gender: GenderType,
        public firstName: string,
        public lastName: string,
        public contactEmail: string,
        public phoneNumber: string,
        public title: string,
        public descrition: string,
        public city: string,
        public expertises: Set<Number>,
        public lastEducation: EducationVo,
        public lastExperience: ExperienceVo
    ) {}
}