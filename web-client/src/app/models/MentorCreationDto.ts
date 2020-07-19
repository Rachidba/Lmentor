import { ExperienceDto } from './ExperienceDto';
import { EducationDto } from './EducationDto';

export class MentorCreationDto {
    constructor(
        public firstName: string,
        public lastName: string,
        public email: string,
        public phoneNumber: string,
        public title: string,
        public descrition: string,
        public sessionPrice: number,
        public educations: Set<EducationDto>,
        public experiences: Set<ExperienceDto>
    ) {}
}