import { Eduction } from './Education.model';
import { Experience } from './Experience.model';
import { Subcategory } from './Subcategory.model';

export interface MentorDetails {
    profileId: number;
    fullName: string;
    phoneNumber: string;
    title: string;
    description: string;
    city: string;
    expertiseAreas: Subcategory[];
    educations: Eduction[];
    experiences: Experience[];
    linkedinProfile: string;
}