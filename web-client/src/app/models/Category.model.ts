import { Subcategory } from './Subcategory.model';

export interface Category {
    id: number;
    categoryName: string;
    subcategories: Subcategory[];
}