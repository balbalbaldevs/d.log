import { mount } from 'enzyme';
import React from 'react';

import Loading from './Loading';
import { LOADING_TYPE } from './Loading.types';

describe('test loading component', () => {
  it('should render loading text', () => {
    const wrapper = mount(<Loading type={LOADING_TYPE.TEXT}>loading</Loading>);

    expect(wrapper.childAt(0).hasClass('loading--text')).toBe(true);
    expect(wrapper.find('.dots').hostNodes().length).toBe(1);
  });

  it('should render loading spinner', () => {
    const wrapper = mount(<Loading type={LOADING_TYPE.SPINNER}>loading</Loading>);

    expect(wrapper.childAt(0).hasClass('loading--spinner')).toBe(true);
    expect(wrapper.find('.spinner').hostNodes().length).toBe(1);
  });

  it('should render loading skeleton', () => {
    const wrapper = mount(
      <Loading type={LOADING_TYPE.SKELETON} rowNum={3}>
        loading
      </Loading>,
    );

    expect(wrapper.prop('rowNum')).toBe(3);
    expect(wrapper.childAt(0).hasClass('loading--skeleton')).toBe(true);
    expect(wrapper.find('.is-multiple').hostNodes().length).toBe(1);
    expect(wrapper.find('.skeleton').hostNodes().length).toBe(3);
  });
});
