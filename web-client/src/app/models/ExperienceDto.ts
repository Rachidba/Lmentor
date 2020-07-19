export class ExperienceDto {
    constructor(
        public companyName: string,
        public startYear: number,
        public startMonth: number,
        public endYear: number,
        public endMonth: number,
        public descrition: string
    ) {}
}