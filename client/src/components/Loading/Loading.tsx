import classNames from 'classnames';
import React from 'react';
import { Props, LOADING_TYPE } from './Loading.types';
import { Dots, Skeleton, Spinner } from './components';
import './Loading.scss';

function Loading(props: Props) {
  const {
    className,
    children,
    rowNum = 1,
    type = 'spinner',
    ...rest
  } = props;

  const loadingClass = classNames(
    'loading',
    `loading--${type}`,
    { 'is-multiple': type === LOADING_TYPE.SKELETON && rowNum > 1 },
    className,
  );

  return (
    <span {...rest} className={loadingClass} role="status" aria-label={children != null ? '로딩중' : undefined}>
      {type === LOADING_TYPE.TEXT && <Dots />}
      {type === LOADING_TYPE.SPINNER && <Spinner />}
      {type === LOADING_TYPE.SKELETON && <Skeleton rowNum={rowNum} />}
      {children}
    </span>
  );
}

export default Loading;
