import axios from 'axios';
import { createAction, createAsyncThunk } from '@reduxjs/toolkit';

const triggerClick = (message) => ({ payload: { message } });

const fetchSampleUsers = async () => {
  const { data } = await axios.get('https://reqres.in/api/users');
  return data.data;
};

export const ReduxSampleActions = {
  getSampleUsers: createAsyncThunk('sample/GET_SAMPLE_USERS', fetchSampleUsers),
  triggerBtnClick: createAction('sample/TRIGGER_BTN_CLICK', triggerClick),
  reset: createAction('sample/RESET'),
};
