import React from 'react';
import classNames from 'classnames';
import { string } from 'prop-types';

const Panel = ({ className, children }) => {
  const panelClassName = classNames('tabpanel', className);

  return <div role="tabpanel" className={panelClassName}>
    {children}
  </div>
};
Panel.propTypes = {
  className: string,
};

export default Panel;