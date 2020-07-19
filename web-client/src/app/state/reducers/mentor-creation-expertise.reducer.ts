import { MentorCreationExpertiseForm } from 'src/app/models/MentorCreationExpertiseForm.model';
import * as MentorCreationExperitseActions from 'src/app/components/mentor-creation/mentor-creation-expertise/mentor-creation-expertise.actions';

export function reducer(state: MentorCreationExpertiseForm = new MentorCreationExpertiseForm(), action: MentorCreationExperitseActions.Actions) {
    switch(action.type) {
        case MentorCreationExperitseActions.PATCH_MENTOR_EXPERTISE:
            return {
                ...state,
                data: { ...state.data, ...action.payload }
            }
        case MentorCreationExperitseActions.CHANGE_VALIDATION_STATUS:
            let isValid = action.isValid;
            return {
                ...state,
                isValid
            }
    }
}

export const selectMentorCreationExpertiseFormData = (state: MentorCreationExpertiseForm) => state.data;
export const selectMentorCreationExpertiseFormIsValid = (state: MentorCreationExpertiseForm) => state.isValid;