push 0
push 3
push 1
push classA
new
lfp
push 5
push -2
lfp
add
lw
copy
lw
push 1
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

function1:
cfp
lra
push 1
lfp
add
lw
push 1
lfp
lw
add
sw
srv
sra
pop
pop
sfp
lrv
lra
js
classA:
function0
function1
classnull:
