import { EducationVo } from './vo/EducationVo';
import { ExperienceVo } from './vo/ExperienceVo';

export class MentorDetailsDto {
    constructor(
        public profileId: number,
        public fullName: string,
        public email: string,
        public phoneNumber: string,
        public title: string,
        public descrition: string,
        public sessionPrice: number,
        public educations: Set<EducationVo>,
        public experiences: Set<ExperienceVo>
    ) {}
}