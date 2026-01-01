
# Photo Module Deep Audit

OK:
- Bitmap reuse
- Canvas effects
- Randomized params
- EXIF stripping

Recommendations:
- Limit max resolution to 4096px
- Use inBitmap for reuse
- Throttle parallel jobs to CPU count
