import defaultSettings from '@/settings'

const title = defaultSettings.title || 'Vue2.x模板'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
