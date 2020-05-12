import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button } from '../index';
import { ReduxSampleActions } from '../../store/actions';

// TODO redux 쓰는 법 익히게 되면 제거
const ReduxSample = () => {
  const {
    sampleButton: { message },
    sampleUsers,
  } = useSelector((state) => state.sample);

  const dispatch = useDispatch();

  const handleClick = () => {
    dispatch(ReduxSampleActions.getSampleUsers());
    dispatch(ReduxSampleActions.triggerBtnClick('SUCCESS'));
  };

  const handleReset = () => dispatch(ReduxSampleActions.reset());

  return (
    <>
      <div style={{ display: 'flex' }}>
        <Button type="button" onClick={handleClick} text={message} />
        <Button type="button" onClick={handleReset} text="Reset" />
      </div>
      {sampleUsers.length > 0 && (
        <ul>
          {sampleUsers.map((user) => (
            <li key={user.id}>{user.email}</li>
          ))}
        </ul>
      )}
    </>
  );
};

export default ReduxSample;
