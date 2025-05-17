export function formatEnum(value?: string): string {
  if (!value) return '';
  return value
  .toLowerCase()
  .replace(/_/g, ' ')
  .replace(/(^\w|\s\w)/g, m => m.toUpperCase());
}
