import React from 'react';
import { arrayOf, shape, string } from 'prop-types';
import { Select as AntdSelect } from 'antd';

const { Option } = AntdSelect;

const Select = ({ data, ...rest }) => (
  <AntdSelect {...rest}>
    {data.length &&
      data.map((option) => (
        <Option key={option.value} value={option.value}>
          {option.text}
        </Option>
      ))}
  </AntdSelect>
);

Select.propTypes = {
  data: arrayOf(
    shape({
      value: string,
      text: string.isRequried,
    }),
  ),
};
export default Select;
