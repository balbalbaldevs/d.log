import { createReducer } from '@reduxjs/toolkit';

import { ReduxSampleActions } from '../actions';
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
  [ReduxSampleActions.getSampleUsers.fulfilled.type]: (state: ReduxSampleState, { payload: userData }) => {
    state.sampleUsers = userData;
  },
  [ReduxSampleActions.triggerBtnClick.type]: (state: ReduxSampleState, action) => {
    const { message } = action.payload;

    state.sampleButton.message = message;
    state.sampleButton.loading = true;
  },
  [ReduxSampleActions.reset.type]: () => initialState,
});

export default reduxSampleReducer;
