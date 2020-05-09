import { combineReducers } from '@reduxjs/toolkit';
import reduxSampleReducer from './ReduxSample/ReduxSample.reducers';

const rootReducer = combineReducers({
  sample: reduxSampleReducer,
});

export default rootReducer;
