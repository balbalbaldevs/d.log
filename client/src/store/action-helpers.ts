import { createAction } from '@reduxjs/toolkit';

function actionWithPayload<T>() {
  return (payload?: T) => ({ payload });
}

export const createStandardAction = <T>(action: string) => createAction(action, actionWithPayload<T>());

// TODO createStandardAction와 같이 createThunkAction 용으로 createAsyncAction helper 생성 필요 (thunkApi를 이용하려면 generic을 받아야함)
