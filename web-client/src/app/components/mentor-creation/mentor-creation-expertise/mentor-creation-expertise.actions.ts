import { Action } from '@ngrx/store';
import { MentorCreationExpertise } from 'src/app/models/MentorCreationExpertise.interface';

export const PATCH_MENTOR_EXPERTISE   = '[MentorCreationExpertise] Patch';
export const CHANGE_VALIDATION_STATUS = '[MenotrCreatinoExpertise] Change validation status';

export class PatchMentorExpertise implements Action {
    readonly type = PATCH_MENTOR_EXPERTISE;

    constructor(public payload: Partial<MentorCreationExpertise>){}
}

export class ChangeValidationStatus implements Action {
    readonly type = CHANGE_VALIDATION_STATUS;

    constructor(public isValid: boolean) {}
}

export type Actions = PatchMentorExpertise | ChangeValidationStatus;