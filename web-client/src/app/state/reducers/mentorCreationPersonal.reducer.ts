import { MentorCreationPersonalForm } from '../../models/MentorCreationPersonalForm.model';
import * as MentorCreationPersonalActions from 'src/app/components/mentor-creation/mentor-creation-personal/mentor-creation-personal.actions';

export function reducer(state: MentorCreationPersonalForm = new MentorCreationPersonalForm(), action: MentorCreationPersonalActions.Actions) {
    switch(action.type) {
        case MentorCreationPersonalActions.PATCH_MENTOR_PERSONAL:
            return {
                ...state,
                data: {...state.data, ...action.payload }
            }
        case MentorCreationPersonalActions.CHANGE_VALIDATION_STATUS_MENTOR_PERSONAL:
            let isValid =  action.isValid;
            return {
                ...state,
                isValid
            }
    }
}

export const selectMentorCreationPersonalFormData = (state: MentorCreationPersonalForm) => state.data;
export const selectMentorCreationPersonalFormIsValid = (state: MentorCreationPersonalForm) => state.isValid;