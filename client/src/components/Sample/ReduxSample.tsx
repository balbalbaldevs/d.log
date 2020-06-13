import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button } from '../index';
import { ReduxSampleActions } from '../../store/actions';
import { UserSampleState } from './ReduxSample.types';
import { AppState } from '../../store/store.types';

// TODO redux 쓰는 법 익히게 되면 제거
const ReduxSample: React.FC = () => {
  const {
    sampleButton: { message },
    sampleUsers,
  } = useSelector((state: AppState) => state.sample);

  const dispatch = useDispatch();

  const handleClick = () => {
    dispatch(ReduxSampleActions.getSampleUsers());
    dispatch(ReduxSampleActions.triggerBtnClick({ message: 'SUCCESS' }));
  };

  const handleReset = () => dispatch(ReduxSampleActions.reset());

  return (
    <>
      <div style={{ display: 'flex' }}>
        <Button type="button" onClick={handleClick}>
          {message}
        </Button>
        <Button type="button" onClick={handleReset}>
          Reset
        </Button>
      </div>
      {sampleUsers.length > 0 && (
        <ul>
          {sampleUsers.map((user: UserSampleState) => (
            <li key={user.id}>{user.email}</li>
          ))}
        </ul>
      )}
    </>
  );
};

export default ReduxSample;
