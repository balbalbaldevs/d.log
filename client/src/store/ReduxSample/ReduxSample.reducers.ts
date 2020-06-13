import { createReducer } from '@reduxjs/toolkit';
import ReduxSampleActions, { GET_SAMPLE_USERS, TRIGGER_BTN_CLICK, RESET } from './ReduxSample.actions';
import { ReduxSampleState } from './ReduxSample.types';

export const initialState: ReduxSampleState = {
  sampleUsers: [],
  sampleButton: {
    message: 'Fetch Users',
    isClicked: false,
    loading: false,
  },
};

// TODO createReducer 타입 추가
const reduxSampleReducer = createReducer(initialState, {
  // TODO createAsyncAction helper 생성 후 fulfilled 상태 타입 확인
  [ReduxSampleActions.getSampleUsers.fulfilled]: (state, { payload: userData }) => {
    console.log(userData);
    state.sampleUsers = userData;
  },
  [TRIGGER_BTN_CLICK]: (state, action) => {
    const { message } = action.payload;

    state.sampleButton.message = message;
    state.sampleButton.loading = true;
  },
  [RESET]: () => initialState,
});

export default reduxSampleReducer;
