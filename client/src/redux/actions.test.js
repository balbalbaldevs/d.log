import { ReduxSampleActions } from './actions';

const actions = [{ ReduxSampleActions }];

describe('test redux actions', () => {
  actions.forEach((actionGroup) => {
    const group = Object.keys(actionGroup)[0];

    it(`should ${group} contain property`, () => {
      const properties = Object.keys(group);

      expect(properties).toBeTruthy();
      expect(group).toHaveProperty(properties[0]);
    });
  });
});
