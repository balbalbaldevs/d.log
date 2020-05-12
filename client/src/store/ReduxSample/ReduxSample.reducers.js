import { createReducer } from '@reduxjs/toolkit';
import ReduxSampleActions from './ReduxSample.actions';

export const initialState = {
  sampleUsers: [],
  sampleButton: {
    message: 'Fetch Users',
    isClicked: false,
  },
};

const reduxSampleReducer = createReducer(initialState, {
  [ReduxSampleActions.getSampleUsers.fulfilled]: (state, { payload: userData }) => {
    state.sampleUsers = userData;
  },
  [ReduxSampleActions.triggerBtnClick]: (state, action) => {
    const { message } = action.payload;

    state.sampleButton.message = message;
    state.sampleButton.loading = true;
  },
  [ReduxSampleActions.reset]: () => initialState,
});

export default reduxSampleReducer;
