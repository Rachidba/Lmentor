import { EducationDto } from './EducationDto';
import { ExperienceDto } from './ExperienceDto';

export class MentorDetailsDto {
    constructor(
        public profileId: number,
        public fullName: string,
        public email: string,
        public phoneNumber: string,
        public title: string,
        public descrition: string,
        public sessionPrice: number,
        public educations: Set<EducationDto>,
        public experiences: Set<ExperienceDto>
    ) {}
}