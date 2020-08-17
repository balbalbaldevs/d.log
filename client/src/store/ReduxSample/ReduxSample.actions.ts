import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

import { AppDispatch } from '@/store';

import { createStandardAction } from '../action-helpers';
import { AppState } from '../store.types';
import { UserSampleState } from './ReduxSample.types';

interface ThunkAPI {
  state: AppState;
  dispatch: AppDispatch;
}

export const GET_SAMPLE_USERS = '@sample/GET_SAMPLE_USERS';
export const TRIGGER_BTN_CLICK = '@sample/TRIGGER_BTN_CLICK';
export const RESET = '@sample/RESET';

const fetchSampleUsers = async () => {
  try {
    const { data } = await axios.get('https://reqres.in/api/users');
    return data.data;
  } catch (error) {
    console.error(error);
  }
};

const ReduxSampleActions = {
  getSampleUsers: createAsyncThunk<UserSampleState[], void, ThunkAPI>(GET_SAMPLE_USERS, fetchSampleUsers),
  triggerBtnClick: createStandardAction<{ message: string }>(TRIGGER_BTN_CLICK),
  reset: createStandardAction(RESET),
};

export default ReduxSampleActions;
