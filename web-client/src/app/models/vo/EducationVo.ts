export class EducationVo {
    constructor(
        public school: string,
        public degree: string,
        public fieldOfStudy: string,
        public startYear: number,
        public endYear: number,
        public description: string
    ) {}
}