import classNames from 'classnames';
import React from 'react';
import { LOADING_TYPE, LoadingProps } from './Loading.types';
import './Loading.scss';

const defaultProps = {
  type: 'spinner',
};

function Loading(props) {
  const { className, children, color, rows, type, style } = props;

  const loadingClass = classNames(
    'loading',
    `loading--${type}`,
    `loading--${color}`,
    { 'is-multiple': type === LOADING_TYPE.SKELETON && rows > 1 },
    className,
  );

  const DotsIcon = () => (
    <i className={classNames('loading__dots-icon', { 'has-text': children })} aria-hidden>
      <span />
    </i>
  );
  const SpinnerIcon = () => <i className="loading__spinner-icon" aria-hidden />;

  return (
    <div className={loadingClass} role="status" aria-label={children !== null && '로딩중'}>
      {type === LOADING_TYPE.TEXT && <DotsIcon />}
      {type === LOADING_TYPE.SPINNER && <SpinnerIcon />}
      {rows > 1 && children.map((item) => <div key={item.type} className="skeleton" style={style} />)}
      {children}
    </div>
  );
}

Loading.defaultProps = defaultProps;

Loading.propTypes = LoadingProps;

export default Loading;
