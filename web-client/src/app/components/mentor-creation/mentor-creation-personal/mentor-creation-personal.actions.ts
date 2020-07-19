import { Action } from '@ngrx/store';
import { MentorCreationPersonal } from 'src/app/models/MentorCreationPersonal.interface';

export const PATCH_MENTOR_PERSONAL                    = '[MentorCreationPersonal] Patch';
export const CHANGE_VALIDATION_STATUS_MENTOR_PERSONAL = '[MentorCreationPersonal] Change validation status';

export class PatchMentorPersonal implements Action {
    readonly type = PATCH_MENTOR_PERSONAL;

    constructor(public payload: Partial<MentorCreationPersonal>) {}
}

export class ChangeValidationStatus implements Action {
    readonly type = CHANGE_VALIDATION_STATUS_MENTOR_PERSONAL;
    
    constructor(public isValid: boolean){}
}

export type Actions = PatchMentorPersonal | ChangeValidationStatus;