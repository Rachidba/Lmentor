import { Subcategory } from './Subcategory.model';

export interface MentorItem {
    fullName: string,
    title: string,  
    description: string,
    expertiseAreas: Subcategory[],
    profileId: number
}