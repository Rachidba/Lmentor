export class ExperienceVo {
    constructor(
        public companyName: string,
        public role: string,
        public startYear: number,
        public startMonth: number,
        public endYear: number,
        public endMonth: number,
        public descrition: string
    ) {}
}