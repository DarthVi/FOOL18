push 0
push 3
push 1
push classA
new
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
print
push 0
push -2
lfp
add
lw
push 5
mm
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
print
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
classnull:
