import './Loading.scss';

import classNames from 'classnames';
import React from 'react';

import { Dots, Skeleton, Spinner } from './components';
import { LOADING_TYPE, Props } from './Loading.types';

function Loading(props: Props) {
  const { className, children, rowNum = 1, type = 'spinner', fontSize, size = 'medium', ...rest } = props;

  const loadingClass = classNames(
    'loading',
    `loading--${type}`,
    { 'is-multiple': type === LOADING_TYPE.SKELETON && rowNum > 1 },
    `loading--${size}`,
    className,
  );

  return (
    <span {...rest} className={loadingClass} role="status" aria-label={children != null ? '로딩중' : undefined}>
      {type === LOADING_TYPE.TEXT && <Dots />}
      {type === LOADING_TYPE.SPINNER && <Spinner />}
      {type === LOADING_TYPE.SKELETON && <Skeleton rowNum={rowNum} fontSize={fontSize} />}
      {children}
    </span>
  );
}

export default Loading;
