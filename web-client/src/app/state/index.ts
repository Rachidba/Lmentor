import { MentorCreationPersonalForm } from 'src/app/models/MentorCreationPersonalForm.model';
import { ActionReducerMap, MetaReducer, createSelector } from '@ngrx/store';
import * as fromMentorCreationPersonal from './reducers/mentorCreationPersonal.reducer';

export interface State {
    mentorCreationPersonal: MentorCreationPersonalForm;
}

export const reducers: ActionReducerMap<State> = {
    mentorCreationPersonal: fromMentorCreationPersonal.reducer
};

export const metaReducers: MetaReducer<State>[] = [];

export const selectMentorCreationPersonalForm = (state: State) => state.mentorCreationPersonal;
export const selectMentorCreationPersonalFormData = createSelector(
    selectMentorCreationPersonalForm,
    fromMentorCreationPersonal.selectMentorCreationPersonalFormData
);
export const selectMentorCreationPersonalFormIsValid = createSelector(
    selectMentorCreationPersonalForm,
    fromMentorCreationPersonal.selectMentorCreationPersonalFormIsValid
);